package org.vikram.chainofresponsibilitypattern;

class SupportTicket {
    private final int id;
    private final String description;
    private final int severityLevel;  // 1: Low, 2: Medium, 3: High

    public SupportTicket(int id, String description, int severityLevel) {
        this.id = id;
        this.description = description;
        this.severityLevel = severityLevel;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getSeverityLevel() {
        return severityLevel;
    }
}

// Chain of responsibility

abstract class SupportHandler{
    protected SupportHandler nextHandler;
    protected int level;

    public void handleRequest(SupportTicket supportTicket){
        if(supportTicket.getSeverityLevel() <= level) {
            resolve(supportTicket);
        }else if(nextHandler != null){
            nextHandler.handleRequest(supportTicket);
        }else{
            System.out.println("No handler available");
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void resolve(SupportTicket supportTicket);
}

class JuniorSupport extends SupportHandler{
    public JuniorSupport() {
        this.level = 1;
    }

    @Override
    protected void resolve(SupportTicket supportTicket) {
        System.out.println("Junior support handling the ticket");
    }
}

class MidLevelSupport extends SupportHandler{

    public MidLevelSupport() {
        this.level=2;
    }

    @Override
    protected void resolve(SupportTicket supportTicket) {
        System.out.println("Mid level support handling the ticket");
    }
}

class SeniorSupport extends SupportHandler{

    public SeniorSupport() {
        this.level = 3;
    }

    @Override
    protected void resolve(SupportTicket supportTicket) {
        System.out.println("Senior level support handling the ticket");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create the chain of responsibility
        SupportHandler juniorSupport = new JuniorSupport();
        SupportHandler midLevelSupport = new MidLevelSupport();
        SupportHandler seniorSupport = new SeniorSupport();

        juniorSupport.setNextHandler(midLevelSupport);
        midLevelSupport.setNextHandler(seniorSupport);

        // Create some support tickets
        SupportTicket ticket1 = new SupportTicket(1, "Password reset request", 1);
        SupportTicket ticket2 = new SupportTicket(2, "Database connection issue", 2);
        SupportTicket ticket3 = new SupportTicket(3, "Production server down", 3);
        SupportTicket ticket4 = new SupportTicket(4, "Server crashed", 4);

        // Process the tickets
        juniorSupport.handleRequest(ticket1);  // Handled by Junior Support
        juniorSupport.handleRequest(ticket2);  // Passed to Mid-level Support
        juniorSupport.handleRequest(ticket3);  // Passed to Senior Support
        juniorSupport.handleRequest(ticket4);
    }
}

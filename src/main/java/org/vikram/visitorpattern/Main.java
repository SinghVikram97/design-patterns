package org.vikram.visitorpattern;

interface Element{
    void accept(Visitor visitor);
}

// Visit and do operation on an element
interface Visitor{
    void visit(FullTime fullTimeEmployee);
    void visit(Intern intern);
    void visit(Contract contract);
}

class FullTime implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Intern implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


class Contract implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class PayrollVisitor implements Visitor{

    @Override
    public void visit(FullTime fullTimeEmployee) {
        System.out.println("Calculating payroll for full time employee");
    }

    @Override
    public void visit(Intern intern) {
        System.out.println("Calculating payroll for intern");
    }

    @Override
    public void visit(Contract contract) {
        System.out.println("Calculating payroll for contractor");
    }
}

class TaxVisitor implements Visitor{

    @Override
    public void visit(FullTime fullTimeEmployee) {
        System.out.println("Calculating tax for full time employee");
    }

    @Override
    public void visit(Intern intern) {
        System.out.println("Calculating tax for intern");
    }

    @Override
    public void visit(Contract contract) {
        System.out.println("Calculating tax for contractor");
    }
}

public class Main {
    public static void main(String[] args) {
        Element fullTime = new FullTime();
        Element intern = new Intern();

        Visitor visitor = new TaxVisitor();

        fullTime.accept(visitor);
    }
}

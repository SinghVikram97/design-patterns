package org.vikram.adapterpattern;

/*
For example write an adaptor for uploading files
Where underlying cloud provider can change
 */

// Client uses
interface IStorageService{
    void uploadFile(String fileData);
}

// Actual method that clients needs
class AmazonS3Client{
    public void uploadFile(String fileData){
        System.out.println("Upload file to S3");
    }
}

class GoogleCloudStorageClient{
    public void uploadFile(String fileData){
        System.out.println("Upload file to GCP");
    }
}

class AmazonAdaptor implements IStorageService{
    private final AmazonS3Client amazonS3Client;

    public AmazonAdaptor(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    @Override
    public void uploadFile(String fileData) {
        amazonS3Client.uploadFile(fileData);
    }
}

class GoogleAdapter implements IStorageService{
    private final GoogleCloudStorageClient googleCloudStorageClient;

    public GoogleAdapter(GoogleCloudStorageClient googleCloudStorageClient) {
        this.googleCloudStorageClient = googleCloudStorageClient;
    }

    @Override
    public void uploadFile(String fileData) {
        googleCloudStorageClient.uploadFile(fileData);
    }
}


public class Main {
    public static void main(String[] args) {
        // client uses adapter
        IStorageService storageService = new AmazonAdaptor(new AmazonS3Client());

        storageService.uploadFile("file data");
    }
}

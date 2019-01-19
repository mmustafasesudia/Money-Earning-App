package com.mm.moneyapp.Offers;

public class WorkerJobs {

    String jobId;
    String cutomerName;
    String Worker_Person_personId;
    String Customer_Person_personId;
    String jobStatus;
    String jobBookingStatus;
    String jobCost;
    String jobHours;
    String jobCreationTime;
    String jobCompleteTime;
    String jobTitle;
    String RattingByCustomer;
    String RattingByWorker;
    String imagePath;

    public WorkerJobs(String imagePath) {
        this.imagePath = imagePath;
    }

    public WorkerJobs(String cutomerName, String jobTitle) {
        this.cutomerName = cutomerName;
        this.jobTitle = jobTitle;
    }

    public WorkerJobs(String cutomerName, String jobTitle, String jobId) {
        this.cutomerName = cutomerName;
        this.jobTitle = jobTitle;
        this.jobId = jobId;
    }

    public WorkerJobs(String cutomerName, String jobTitle, String jobId, String jobCreationTime) {
        this.cutomerName = cutomerName;
        this.jobTitle = jobTitle;
        this.jobId = jobId;
        this.jobCreationTime = jobCreationTime;
    }

    public WorkerJobs(String jobId, String cutomerName, String Worker_Person_personId, String Customer_Person_personId, String jobStatus, String jobBookingStatus, String jobCost, String jobHours, String jobCreationTime, String jobCompleteTime, String jobTitle, String RattingByCustomer, String RattingByWorker) {
        this.jobId = jobId;
        this.Worker_Person_personId = Worker_Person_personId;
        this.Customer_Person_personId = Customer_Person_personId;
        this.jobStatus = jobStatus;
        this.jobBookingStatus = jobBookingStatus;
        this.jobCost = jobCost;
        this.jobHours = jobHours;
        this.jobCreationTime = jobCreationTime;
        this.jobCompleteTime = jobCompleteTime;
        this.cutomerName = cutomerName;
        this.jobTitle = jobTitle;
        this.RattingByCustomer = RattingByCustomer;
        this.RattingByWorker = RattingByWorker;

    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRattingByCustomer() {
        return RattingByCustomer;
    }

    public void setRattingByCustomer(String rattingByCustomer) {
        RattingByCustomer = rattingByCustomer;
    }

    public String getRattingByWorker() {
        return RattingByWorker;
    }

    public void setRattingByWorker(String rattingByWorker) {
        RattingByWorker = rattingByWorker;
    }

    public String getCutomerName() {
        return cutomerName;
    }

    public void setCutomerName(String cutomerName) {
        this.cutomerName = cutomerName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getWorker_Person_personId() {
        return Worker_Person_personId;
    }

    public void setWorker_Person_personId(String Worker_Person_personId) {
        this.Worker_Person_personId = Worker_Person_personId;
    }

    public String getCustomer_Person_personId() {
        return Customer_Person_personId;
    }

    public void setCustomer_Person_personId(String Customer_Person_personId) {
        this.Customer_Person_personId = Customer_Person_personId;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobBookingStatus() {
        return jobBookingStatus;
    }

    public void setJobBookingStatus(String jobBookingStatus) {
        this.jobBookingStatus = jobBookingStatus;
    }

    public String getJobCost() {
        return jobCost;
    }

    public void setJobCost(String jobCost) {
        this.jobCost = jobCost;
    }

    public String getJobHours() {
        return jobHours;
    }

    public void setJobHours(String jobHours) {
        this.jobHours = jobHours;
    }

    public String getJobCreationTime() {
        return jobCreationTime;
    }

    public void setJobCreationTime(String jobCreationTime) {
        this.jobCreationTime = jobCreationTime;
    }

    public String getJobCompleteTime() {
        return jobCompleteTime;
    }

    public void setJobCompleteTime(String jobCompleteTime) {
        this.jobCompleteTime = jobCompleteTime;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


}

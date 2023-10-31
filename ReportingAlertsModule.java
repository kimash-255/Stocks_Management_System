import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Report {
    private String reportName;
    private String content;

    public Report(String reportName, String content) {
        this.reportName = reportName;
        this.content = content;
    }

    public String getReportName() {
        return reportName;
    }

    public String getContent() {
        return content;
    }
}

class ReportManager {
    private List<Report> reports;

    public ReportManager() {
        reports = new ArrayList<>();
    }

    public void addReport(Report report) {
        reports.add(report);
    }

    public void removeReport(String reportName) {
        reports.removeIf(report -> report.getReportName().equals(reportName));
    }

    public List<Report> listReports() {
        return new ArrayList<>(reports);
    }
}

public class ReportingAlertsModule {
    public static void run(Scanner scanner) {
        ReportManager reportManager = new ReportManager();

        boolean running = true;
        while (running) {
            System.out.println("Reporting and Alerts Menu");
            System.out.println("1. Create Report");
            System.out.println("2. Remove Report");
            System.out.println("3. List Reports");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter report name: ");
                    String reportName = scanner.nextLine();
                    System.out.print("Enter report content: ");
                    String content = scanner.nextLine();
                    Report report = new Report(reportName, content);
                    reportManager.addReport(report);
                    System.out.println("Report created.");
                    break;
                case 2:
                    System.out.print("Enter report name to remove: ");
                    String reportNameToRemove = scanner.nextLine();
                    reportManager.removeReport(reportNameToRemove);
                    System.out.println("Report removed.");
                    break;
                case 3:
                    List<Report> reports = reportManager.listReports();
                    if (reports.isEmpty()) {
                        System.out.println("No reports found.");
                    } else {
                        System.out.println("Reports:");
                        for (Report report : reports) {
                            System.out.println("Report Name: " + report.getReportName());
                            System.out.println("Content: " + report.getContent());
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}

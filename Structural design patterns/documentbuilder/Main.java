package documentbuilder;

public class Main {
    public static void main(String[] args) {
        // Create a report using the Builder pattern
        Report report = new Report.Builder()
                .setTitle("Annual Financial Report")
                .setAuthor("John Doe")
                .addSection("Executive Summary")
                .addSection("Financial Overview")
                .addSection("Future Projections")
                .addSection("Conclusion")
                .build();

        // Print the report
        System.out.println(report);
    }
}

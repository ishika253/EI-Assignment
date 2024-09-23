package documentbuilder;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private String title;
    private String author;
    private List<String> sections;

    private Report(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.sections = builder.sections;
    }

    public static class Builder {
        private String title;
        private String author;
        private List<String> sections = new ArrayList<>();

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder addSection(String section) {
            this.sections.add(section);
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder reportString = new StringBuilder();
        reportString.append("Title: ").append(title).append("\n")
                .append("Author: ").append(author).append("\n\n")
                .append("Sections:\n");
        for (String section : sections) {
            reportString.append(section).append("\n");
        }
        return reportString.toString();
    }
}

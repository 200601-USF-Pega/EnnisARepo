package com.revature.servlets;

public class GenericPageFormat {


    String htmlStart = "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "    <link rel=\"stylesheet\" href=\"webpage.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "\n" +
            "    <div class=\"sticky-top topnav\" id=\"Welcome\">\n" +
            "        <span>\n" +
            "            <header>\n" +
            "                <h1>Escape Room Reservation System</h1>\n" +
            "                <h3>The classic console app comes to the World Wide Web</h3>\n" +
            "                <h4>By: Ajene Ennis</h4>\n" +
            "                <br>\n" +
            "            </header>\n" +
            "        </span>\n" +
            "    </div>";
    String htmlEnd = "</body></head>";

    public String getHtmlStart() {
        return htmlStart;
    }

    public void setHtmlStart(String htmlStart) {
        this.htmlStart = htmlStart;
    }

    public String getHtmlEnd() {
        return htmlEnd;
    }

    public void setHtmlEnd(String htmlEnd) {
        this.htmlEnd = htmlEnd;
    }
}

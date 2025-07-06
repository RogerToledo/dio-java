import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var process = false;
        List<String> lineList = new ArrayList<>();

        while(!process) {
            System.out.println("Digite as entrada separadas por vígula (name,joão,text) ou . (ponto) para processar");
            var line = scanner.nextLine();

            if (line.equals(".")) {
                process = true;
            }

            lineList.add(line);
        }

        var json = getJson(lineList);
        System.out.println(json);

        System.out.println("==========================================");

        var xml = getXML(lineList);
        System.out.println(xml);

        System.out.println("==========================================");

        var yaml = getYaml(lineList);
        System.out.println(yaml);

    }

    private static String getJson(List<String> list) {
        var builder = new StringBuilder();
        var listLength = list.size();

        builder.append("{\n");
        builder.append("\t\"user\":[\n");

        for (String line : list) {
            listLength--;

            if (line.equals(".")) {
                break;
            }

            var values = line.split(",");
            switch (values[2]) {
                case "text" -> {
                    if (values[0].equals("name")) {
                        builder.append("\t\t{\n");
                    }
                    var value = String.format("\t\t\t\"%s\":\"%s\",\n", values[0], values[1]);
                    builder.append(value);
                }
                case "int" -> {
                    var value = String.format("\t\t\t\"%s\":%d,\n", values[0], Integer.parseInt(values[1]));
                    builder.append(value);
                }
                case "double" -> {
                    var value = String.format("\t\t\t\"%s\":%.2f\n", values[0], Double.parseDouble(values[1]));
                    builder.append(value);
                    if (listLength == 1) {
                        builder.append("\t\t}\n");
                    } else {
                        builder.append("\t\t},\n");
                    }
                }
            }
        }

        builder.append("\t]\n");
        builder.append("}");

        return builder.toString();
    }

    private static String getXML(List<String> list) {
        var builder = new StringBuilder();

        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        builder.append("<users>\n");

        for (String line : list) {
            if (line.equals(".")) {
                break;
            }

            var values = line.split(",");
            switch (values[2]) {
                case "text" -> {
                    if (values[0].equals("name")) {
                        builder.append("\t<user>\n");
                    }
                    var value = String.format("\t\t<%s>%s</%s>\n", values[0], values[1], values[0]);
                    builder.append(value);
                }
                case "int" -> {
                    var value = String.format("\t\t<%s>%d</%s>\n", values[0], Integer.parseInt(values[1]), values[0]);
                    builder.append(value);
                }
                case "double" -> {
                    var value = String.format("\t\t<%s>%.2f</%s>\n", values[0], Double.parseDouble(values[1]), values[0]);
                    builder.append(value);
                    builder.append("\t</user>\n");
                }
            }
        }

        builder.append("</users>");

        return builder.toString();
    }

    private static String getYaml(List<String> list) {
        var builder = new StringBuilder();

        builder.append("users:\n");

        for (String line : list) {
            if (line.equals(".")) {
                break;
            }

            var values = line.split(",");
            switch (values[2]) {
                case "text" -> {
                    String value;
                    if (values[0].equals("name")) {
                        value = String.format("  - %s: %s\n", values[0], values[1]);
                    } else {
                        value = String.format("    %s: %s\n", values[0], values[1]);
                    }

                    builder.append(value);
                }
                case "int" -> {
                    var value = String.format("    %s: %d\n", values[0], Integer.parseInt(values[1]));
                    builder.append(value);
                }
                case "double" -> {
                    var value = String.format("    %s: %.2f\n", values[0], Double.parseDouble(values[1]));
                    builder.append(value);
                }
            }
        }

        return builder.toString();
    }
}
public class TextBlockExample {
    public static void main(String[] args) {
        String text = """
                  {
                    "name": "John Doe",
                    "age": 45,
                    "address": "Doe Street, 23, Java Town"
                  }
                """;
        System.out.println(text);

        sqlStatement();
    }

    private static void sqlStatement() {
        String sql = """
                SELECT id, firstName, lastName \s
                FROM Employee
                WHERE departmentId = "IT" \
                ORDER BY lastName, firstName
                """;
        System.out.println(sql);
    }
}

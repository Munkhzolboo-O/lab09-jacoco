package mn.edu.must.sqat;

/**
 * Ð¢ÑÑ‚Ð³ÑÐ»ÑÐ³ Ñ‚Ð¾Ð¾Ñ†Ð¾Ð¾Ð»Ð¾Ð³Ñ‡ â€” Ð›Ð°Ð± 9-Ð¸Ð¹Ð½ Ð±Ò¯Ñ‚Ñ†Ð¸Ð¹Ð½ Ñ‚ÐµÑÑ‚Ð¸Ð¹Ð½ Ð±Ð°Ð¹.
 * Ð¡Ð¿ÐµÑ†Ð¸Ñ„Ð¸ÐºÐ°Ñ†Ð¸ (oracle):
 *   letterGrade: 90-100 -> "A", 80-89.99 -> "B", 70-79.99 -> "C",
 *                60-69.99 -> "D", 0-59.99 -> "F";
 *                0-Ð¸Ð¾Ñ Ð±Ð°Ð³Ð°, 100-Ð°Ð°Ñ Ð¸Ñ… Ð±Ð¾Ð» IllegalArgumentException.
 *   gpa:         Ð´Ò¯Ð½Ð³Ò¯Ò¯Ð´Ð¸Ð¹Ð½ Ð³Ð¾Ð»Ñ‡ (A=4, B=3, C=2, D=1, F=0);
 *                null ÑÑÐ²ÑÐ» Ñ…Ð¾Ð¾ÑÐ¾Ð½ Ð¼Ð°ÑÑÐ¸Ð²Ñ‚ IllegalArgumentException.
 *   scholarship: ÑÐ°Ñ…Ð¸Ð»Ð³Ñ‹Ð½ Ð·Ó©Ñ€Ñ‡Ð¸Ð»Ñ‚ÑÐ¹ Ð±Ð¾Ð» 0;
 *                Ð³Ð¾Ð»Ñ‡ >= 3.8 Ð±Ð° ÐºÑ€ÐµÐ´Ð¸Ñ‚ >= 15 Ð±Ð¾Ð» 100;
 *                Ð³Ð¾Ð»Ñ‡ >= 3.4 Ð±Ð° ÐºÑ€ÐµÐ´Ð¸Ñ‚ >= 12 Ð±Ð¾Ð» 70;
 *                Ð³Ð¾Ð»Ñ‡ >= 3.0 Ð±Ð¾Ð» 50; Ð±ÑƒÑÐ°Ð´ Ñ‚Ð¾Ñ…Ð¸Ð¾Ð»Ð´Ð¾Ð»Ð´ 0.
 *                Ð“Ð¾Ð»Ñ‡ 0-4, ÐºÑ€ÐµÐ´Ð¸Ñ‚ 0+ Ñ…ÑÐ·Ð³Ð°Ð°Ñ€Ð°Ð°Ñ Ð³Ð°Ð´ÑƒÑƒÑ€ Ð±Ð¾Ð» IllegalArgumentException.
 */
public class ScholarshipCalculator {

    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("ÐžÐ½Ð¾Ð¾ 0-100 Ñ…Ð¾Ð¾Ñ€Ð¾Ð½Ð´ Ð±Ð°Ð¹Ñ… Ñ‘ÑÑ‚Ð¾Ð¹: " + score);
        }
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public double gpa(double[] scores) {
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("Ð”Ò¯Ð½Ð³Ò¯Ð¹ Ð³Ð¾Ð»Ñ‡ Ð±Ð¾Ð´Ð¾Ñ… Ð±Ð¾Ð»Ð¾Ð¼Ð¶Ð³Ò¯Ð¹");
        }
        double total = 0;
        for (double s : scores) {
            switch (letterGrade(s)) {
                case "A": total += 4; break;
                case "B": total += 3; break;
                case "C": total += 2; break;
                case "D": total += 1; break;
                default:  break;
            }
        }
        return total / scores.length;
    }

    public int scholarship(double gpa, int credits, boolean hasViolation) {
        if (gpa < 0 || gpa > 4 || credits < 0) {
            throw new IllegalArgumentException("Ð‘ÑƒÑ€ÑƒÑƒ Ð¾Ñ€Ð¾Ð»Ñ‚");
        }
        if (hasViolation) return 0;
        if (gpa >= 3.8 && credits >= 15) return 100;
        if (gpa >= 3.4 && credits >= 12) return 70;
        if (gpa >= 3.0) return 50;
        return 0;
    }
}

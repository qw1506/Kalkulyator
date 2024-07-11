import java.io.IOException;
import java.util.Scanner;

public class Kalkulyator {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String primStroka = in.nextLine();
        String prim = primStroka.replaceAll(" ", ""); // удаляем все пробелы в строке вводимые пользователем
        // System.out.println("Новое поле после удаления пробелов: " + prim); // вспомогательный код (спрятать)

        int word = prim.length(); // посчитать количество символов в строке с помощью функции length
        // System.out.println("Кол-во символов в строке: " + word); // вспомогательный код (спрятать)

        // поиск знаков +, -, *, / если их больше одного калькулятор останавливает работу
        int wordPlus = prim.replaceAll("[^+,]*", "").length();
        int wordMinus = prim.replaceAll("[^-,]*", "").length();
        int wordProiz = prim.replaceAll("[^*,]*", "").length();
        int wordDelen = prim.replaceAll("[^/,]*", "").length();
        int wordSumZnak = wordPlus + wordProiz + wordMinus + wordDelen;
        // System.out.println("Кол-во символов + в строке: " + wordPlus); // вспомогательный код (спрятать)
        // System.out.println("Кол-во символов - в строке: " + wordMinus); // вспомогательный код (спрятать)
        // System.out.println("Кол-во символов * в строке: " + wordProiz); // вспомогательный код (спрятать)
        // System.out.println("Кол-во символов / в строке: " + wordDelen); // вспомогательный код (спрятать)
        // System.out.println("Сумма всех знаков +, -, *, / в строке: " + wordSumZnak); // вспомогательный код (спрятать)
        if (wordSumZnak>1) {
            throw new IOException(); // Выражение не удовлетворяет условиям задания, так как должно быть два операнда и один оператор (+, -, *, /)
            /* System.out.println("Выражение не удовлетворяет условиям задания, так как должно быть два операнда и один оператор (+, -, *, /)");
            return; */
        }

        // выводим результат расчёта в зависимости от кол-ва символов в строке ввода
        if (word == 0){
            throw new IOException(); // Поле пустое, пожалуйста, введите выражение
            // System.out.println("Поле пустое, пожалуйста, введите выражение");
        } else if (word <= 2) {
            throw new IOException(); // Строка не является математической операцией
            // System.out.println("Строка не является математической операцией");
        } else if (prim.contains("I") || prim.contains("II") || prim.contains("III") || prim.contains("IV") || prim.contains("V") || prim.contains("VI") || prim.contains("VII") || prim.contains("VIII") || prim.contains("IX") || prim.contains("X")) {
            // ====== БЛОК ПО РАБОТЕ С РИМСКИМИ ЦИФРАМИ ======
            // System.out.println("Есть римские цифры: I, II, III, IV, V, VI, VII, VIII, IX, X"); // вспомогательный код (спрятать)

            // с помощью indexOf ищем где в строке встречается знак и выводим номер строки
            int plus = prim.indexOf("+");
            int minus = prim.indexOf("-");
            int proiz = prim.indexOf("*");
            int delen = prim.indexOf("/");

            String [] primSplit = prim.split("[+-/*]"); // в квадратных [] скобках знаки, которые нужно удлаить из вводимой строки
            for (int i=0; i<primSplit.length; i++) {
                // System.out.println(primSplit[i]); // вспомогательный код (спрятать)
            }

            String a, b, c; // задаём значения a и b для primSplit, выводим отдельно эти значения из массива for primSplit
            a = primSplit[0];
            b = primSplit[1];
            // System.out.println("Цифра a: " + a); // вспомогательный код (спрятать)
            // System.out.println("Цифра b: " + b); // вспомогательный код (спрятать)

            // проверка сроки на наличие арабских и римских цифр с выводом ошибки
            if ((a.contains("I") || a.contains("II") || a.contains("III") || a.contains("IV") || a.contains("V") || a.contains("VI") || a.contains("VII") || a.contains("VIII") || a.contains("IX") || a.contains("X")) && (b.contains("1") || b.contains("2") || b.contains("3") || b.contains("4") || b.contains("5") || b.contains("6") || b.contains("7") || b.contains("8") || b.contains("9") || b.contains("10"))) {
                throw new IOException(); // Калькулятор не умеет работать одновременно с римскими и арабскими числами
                /* System.out.println("Калькулятор не умеет работать одновременно с римскими и арабскими числами");
                return; */
            } else if ((a.contains("1") || a.contains("2") || a.contains("3") || a.contains("4") || a.contains("5") || a.contains("6") || a.contains("7") || a.contains("8") || a.contains("9") || a.contains("10")) && (b.contains("I") || b.contains("II") || b.contains("III") || b.contains("IV") || b.contains("V") || b.contains("VI") || b.contains("VII") || b.contains("VIII") || b.contains("IX") || b.contains("X"))) {
                throw new IOException(); // Калькулятор не умеет работать одновременно с римскими и арабскими числами
                /* System.out.println("Калькулятор не умеет работать одновременно с римскими и арабскими числами");
                return; */
            }

            // создаём конвертер для значения a, с переводом строки в число, , при этом первоначальное значение int надо поставить 0, чтобы в System.out.println, в конце вышел результат
            int rimA = 0;
            switch (a) {
                case "I":
                    rimA = Integer.parseInt(String.valueOf(1));
                    break;
                case "II":
                    rimA = Integer.parseInt(String.valueOf(2));
                    break;
                case "III":
                    rimA = Integer.parseInt(String.valueOf(3));
                    break;
                case "IV":
                    rimA = Integer.parseInt(String.valueOf(4));
                    break;
                case "V":
                    rimA = Integer.parseInt(String.valueOf(5));
                    break;
                case "VI":
                    rimA = Integer.parseInt(String.valueOf(6));
                    break;
                case "VII":
                    rimA = Integer.parseInt(String.valueOf(7));
                    break;
                case "VIII":
                    rimA = Integer.parseInt(String.valueOf(8));
                    break;
                case "IX":
                    rimA = Integer.parseInt(String.valueOf(9));
                    break;
                case "X":
                    rimA = Integer.parseInt(String.valueOf(10));
                    break;
                default:
                    throw new IOException(); // Калькулятор может работать только с числами от I до X включительно
                    /* System.out.println("Калькулятор может работать только с числами от I до X включительно");
                    return; */
            }
            // System.out.println("Цифра a при конвертации: " + rimA); // вспомогательный код (спрятать)

            // создаём конвертер для значения b, с переводом строки в число, при этом первоначальное значение int надо поставить 0, чтобы в System.out.println, в конце вышел результат
            int rimB = 0;
            switch (b) {
                case "I":
                    rimB = Integer.parseInt(String.valueOf(1));
                    break;
                case "II":
                    rimB = Integer.parseInt(String.valueOf(2));
                    break;
                case "III":
                    rimB = Integer.parseInt(String.valueOf(3));
                    break;
                case "IV":
                    rimB = Integer.parseInt(String.valueOf(4));
                    break;
                case "V":
                    rimB = Integer.parseInt(String.valueOf(5));
                    break;
                case "VI":
                    rimB = Integer.parseInt(String.valueOf(6));
                    break;
                case "VII":
                    rimB = Integer.parseInt(String.valueOf(7));
                    break;
                case "VIII":
                    rimB = Integer.parseInt(String.valueOf(8));
                    break;
                case "IX":
                    rimB = Integer.parseInt(String.valueOf(9));
                    break;
                case "X":
                    rimB = Integer.parseInt(String.valueOf(10));
                    break;
                default:
                    throw new IOException(); // Калькулятор может работать только с числами от I до X включительно
                    /* System.out.println("Калькулятор может работать только с числами от I до X включительно");
                    return; */
            }
            // System.out.println("Цифра b при конвертации: " + rimB); // вспомогательный код (спрятать)

            // арифметические операции после конвертации римских цифр, обязательно ставим = 0, чтобы в System.out.println, в конце вышел результат
            int rezultat = 0;
            if (plus > 0) {
                rezultat = rimA + rimB;
            } else if (minus > 0) {
                rezultat = rimA - rimB;
            } else if (proiz > 0) {
                rezultat = rimA * rimB;
            } else if (delen > 0) {
                rezultat = rimA / rimB;
            } else {
                throw new IOException(); // Ошибка в коде
                // System.out.println("Ошибка в коде");
            }
            // System.out.println("Результат: " + rezultat); // вспомогательный код (спрятать)

            // преобразуем число в строку через Integer.toString
            String obratnoVTekst = Integer.toString(rezultat);
            // System.out.println("Результат Integer.toString(rezultat): " + obratnoVTekst); // вспомогательный код (спрятать)

            // переводим обратно арабское цисло в рисмкое из предыдущего int rezultat
            String obratnoVRim = String.valueOf(0);
            switch (obratnoVTekst) {
                case "1":
                    obratnoVRim = "I";
                    break;
                case "2":
                    obratnoVRim ="II";
                    break;
                case "3":
                    obratnoVRim = "III";
                    break;
                case "4":
                    obratnoVRim = "IV";
                    break;
                case "5":
                    obratnoVRim = "V";
                    break;
                case "6":
                    obratnoVRim = "VI";
                    break;
                case "7":
                    obratnoVRim = "VII";
                    break;
                case "8":
                    obratnoVRim = "VIII";
                    break;
                case "9":
                    obratnoVRim = "IX";
                    break;
                case "10":
                    obratnoVRim = "X";
                    break;
                case "11":
                    obratnoVRim = "XI";
                    break;
                case "12":
                    obratnoVRim = "XII";
                    break;
                case "13":
                    obratnoVRim = "XIII";
                    break;
                case "14":
                    obratnoVRim = "XIV";
                    break;
                case "15":
                    obratnoVRim = "XV";
                    break;
                case "16":
                    obratnoVRim = "XVI";
                    break;
                case "17":
                    obratnoVRim = "XVII";
                    break;
                case "18":
                    obratnoVRim = "XVIII";
                    break;
                case "19":
                    obratnoVRim = "XIX";
                    break;
                case "20":
                    obratnoVRim = "XX";
                    break;
                case "21":
                    obratnoVRim = "XXI";
                    break;
                case "22":
                    obratnoVRim = "XXII";
                    break;
                case "23":
                    obratnoVRim = "XXIII";
                    break;
                case "24":
                    obratnoVRim = "XXIV";
                    break;
                case "25":
                    obratnoVRim = "XXV";
                    break;
                case "26":
                    obratnoVRim = "XXVI";
                    break;
                case "27":
                    obratnoVRim = "XXVII";
                    break;
                case "28":
                    obratnoVRim = "XXVIII";
                    break;
                case "29":
                    obratnoVRim = "XXIX";
                    break;
                case "30":
                    obratnoVRim = "XXX";
                    break;
                case "31":
                    obratnoVRim = "XXXI";
                    break;
                case "32":
                    obratnoVRim = "XXXII";
                    break;
                case "33":
                    obratnoVRim = "XXXIII";
                    break;
                case "34":
                    obratnoVRim = "XXXIV";
                    break;
                case "35":
                    obratnoVRim = "XXXV";
                    break;
                case "36":
                    obratnoVRim = "XXXVI";
                    break;
                case "37":
                    obratnoVRim = "XXXVII";
                    break;
                case "38":
                    obratnoVRim = "XXXVII";
                    break;
                case "39":
                    obratnoVRim = "XXXIX";
                    break;
                case "40":
                    obratnoVRim = "XL";
                    break;
                case "41":
                    obratnoVRim = "XLI";
                    break;
                case "42":
                    obratnoVRim = "XLII";
                    break;
                case "43":
                    obratnoVRim = "XLIII";
                    break;
                case "44":
                    obratnoVRim = "XLIV";
                    break;
                case "45":
                    obratnoVRim = "XLV";
                    break;
                case "46":
                    obratnoVRim = "XLVI";
                    break;
                case "47":
                    obratnoVRim = "VLVII";
                    break;
                case "48":
                    obratnoVRim = "XLVIII";
                    break;
                case "49":
                    obratnoVRim = "XLIX";
                    break;
                case "50":
                    obratnoVRim = "L";
                    break;
                case "51":
                    obratnoVRim = "LI";
                    break;
                case "52":
                    obratnoVRim = "LII";
                    break;
                case "53":
                    obratnoVRim = "LIII";
                    break;
                case "54":
                    obratnoVRim = "LIV";
                    break;
                case "55":
                    obratnoVRim = "LV";
                    break;
                case "56":
                    obratnoVRim = "LVI";
                    break;
                case "57":
                    obratnoVRim = "LVII";
                    break;
                case "58":
                    obratnoVRim = "LVIII";
                    break;
                case "59":
                    obratnoVRim = "LIX";
                    break;
                case "60":
                    obratnoVRim = "LX";
                    break;
                case "61":
                    obratnoVRim = "LXI";
                    break;
                case "62":
                    obratnoVRim = "LXII";
                    break;
                case "63":
                    obratnoVRim = "LXIII";
                    break;
                case "64":
                    obratnoVRim = "LXIV";
                    break;
                case "65":
                    obratnoVRim = "LXV";
                    break;
                case "66":
                    obratnoVRim = "LXVI";
                    break;
                case "67":
                    obratnoVRim = "LXVII";
                    break;
                case "68":
                    obratnoVRim = "LXVIII";
                    break;
                case "69":
                    obratnoVRim = "LXIX";
                    break;
                case "70":
                    obratnoVRim = "LXX";
                    break;
                case "71":
                    obratnoVRim = "LXXI";
                    break;
                case "72":
                    obratnoVRim = "LXXII";
                    break;
                case "73":
                    obratnoVRim = "LXXIII";
                    break;
                case "74":
                    obratnoVRim = "LXXIV";
                    break;
                case "75":
                    obratnoVRim = "LXXV";
                    break;
                case "76":
                    obratnoVRim = "LXXVI";
                    break;
                case "77":
                    obratnoVRim = "LXXVII";
                    break;
                case "78":
                    obratnoVRim = "LXXVIII";
                    break;
                case "79":
                    obratnoVRim = "LXXIX";
                    break;
                case "80":
                    obratnoVRim = "LXXX";
                    break;
                case "81":
                    obratnoVRim = "LXXXI";
                    break;
                case "82":
                    obratnoVRim = "LXXXII";
                    break;
                case "83":
                    obratnoVRim = "LXXXIII";
                    break;
                case "84":
                    obratnoVRim = "LXXXIV";
                    break;
                case "85":
                    obratnoVRim = "LXXXV";
                    break;
                case "86":
                    obratnoVRim = "LXXXVI";
                    break;
                case "87":
                    obratnoVRim = "LXXXVII";
                    break;
                case "88":
                    obratnoVRim = "LXXXVIII";
                    break;
                case "89":
                    obratnoVRim = "LXXXIX";
                    break;
                case "90":
                    obratnoVRim = "XC";
                    break;
                case "91":
                    obratnoVRim = "XCI";
                    break;
                case "92":
                    obratnoVRim = "XCII";
                    break;
                case "93":
                    obratnoVRim = "XCIII";
                    break;
                case "94":
                    obratnoVRim = "XCIV";
                    break;
                case "95":
                    obratnoVRim = "XCV";
                    break;
                case "96":
                    obratnoVRim = "XCVI";
                    break;
                case "97":
                    obratnoVRim = "XCVII";
                    break;
                case "98":
                    obratnoVRim = "XCVIII";
                    break;
                case "99":
                    obratnoVRim = "XCIX";
                    break;
                case "100":
                    obratnoVRim = "C";
                    break;
                default:
                    if (rezultat<0) {
                        throw new IOException(); // В римской системе нет отрицательных значений
                        // System.out.println("В римской системе нет отрицательных значений");
                    } else {
                        throw new IOException(); // Расчёт невозможен, так как в римской системе нет цифры 0 (ноль)
                        // System.out.println("Расчёт невозможен, так как в римской системе нет цифры 0 (ноль)");
                    }
                    // return;
            }
            // System.out.println("Результат обратного перевода в римскую систему счисления через obratnoVRim: " + obratnoVRim); // вспомогательный код (спрятать)
            System.out.println("Результат: " + obratnoVRim + " [" + obratnoVTekst + "]");
            // ====== КОНЕЦ БЛОК ПО РАБОТЕ С РИМСКИМИ ЦИФРАМИ ======


        } else if (prim.contains("+") || prim.contains("-") || prim.contains("*") || prim.contains("/")) { // .contains проверяет есть ли в строке ввода один из символов
            // ====== РАБОТА ТОЛЬКО С АРАБСКИМИ ЧИСЛАМИ ======
            // System.out.println("Есть один из арифметических знаков: +, -, *, /");

            // с помощью indexOf ищем где в строке встречается знак и выводим номер строки
            int plus = prim.indexOf("+");
            int minus = prim.indexOf("-");
            int proiz = prim.indexOf("*");
            int delen = prim.indexOf("/");
            /* if (plus > 0) { // результат работы поиска знака +, -, *, / в строке ввода
                System.out.println("Есть знак +, его индекс: " + plus);
            } else if (minus > 0) {
                System.out.println("Есть знак -, его индекс: : " + minus);
            } else if (proiz > 0) {
                System.out.println("Есть знак *, его индекс: : " + proiz);
            } else if (delen > 0) {
                System.out.println("Есть знак /, его индекс: : " + delen);
            } */

            // удаляем из строки знаки "+", "-", "*", и "/"
            String [] primSplit = prim.split("[+-/* ]"); // в квадратных [] скобках знаки, которые нужно удлаить из вводимой строки
            for (int i=0; i<primSplit.length; i++) {
                // System.out.println(primSplit[i]); // вспомогательный код (спрятать)
            }

            int a, b; // задаём после primSplit значения a и b для оставшихся цифр без учёта знака
            a = Integer.parseInt(primSplit[0]); // переводим текст в число после primSplit
            b = Integer.parseInt(primSplit[1]); // переводим текст в число после primSplit
            // System.out.println("Перевод строки a в число: " + a); // вспомогательный код (спрятать)
            // System.out.println("Перевод строки b в число: " + b); // вспомогательный код (спрятать)

            if (a == 0 || b == 0) {
                throw new IOException(); // Калькулятор работает только с целыми числами от 1 до 10 включительно
                /* System.out.println("Калькулятор работает только с целыми числами от 1 до 10 включительно");
                return; */
            }

            if (word == 3) {
                // System.out.println("Условие 3 символа в строке"); // вспомогательный код (спрятать)

                int rezultat;
                if (a>=11 || b>=11) { // ограничение на число до 10 включительно
                    throw new IOException(); // Калькулятор работает только с целыми числами от 1 до 10 включительно
                    // System.out.println("Калькулятор работает только с целыми числами от 1 до 10 включительно");
                } else {
                    if (plus > 0) {
                        // System.out.println("Есть знак +, его индекс: " + plus); // вспомогательный код (спрятать)
                        rezultat = a+b;
                        System.out.println("Результат: " + rezultat);
                    } else if (minus > 0) {
                        // System.out.println("Есть знак -, его индекс: " + minus); // вспомогательный код (спрятать)
                        rezultat = a-b;
                        System.out.println("Результат: " + rezultat);
                    } else if (proiz > 0) {
                        // System.out.println("Есть знак *, его индекс: " + proiz); // вспомогательный код (спрятать)
                        rezultat = a*b;
                        // System.out.println("Результат: " + rezultat);
                    } else if (delen > 0) {
                        // System.out.println("Есть знак /, его индекс: " + delen); // вспомогательный код (спрятать)
                        rezultat = a/b;
                        System.out.println("Результат: " + rezultat);
                    }
                }

            } else if (word == 4) {
                // System.out.println("Условие 4 символа в строке"); // вспомогательный код (спрятать)

                int rezultat;
                if (a>=11 || b>=11) { // ограничение на число до 10 включительно
                    throw new IOException(); // Калькулятор может работать только с целыми числами от 1 до 10 включительно
                    // System.out.println("Калькулятор может работать только с целыми числами от 1 до 10 включительно");
                } else {
                    if (plus > 0) {
                        // System.out.println("Есть знак +, его индекс: " + plus); // вспомогательный код (спрятать)
                        rezultat = a+b;
                        System.out.println("Результат: " + rezultat);
                    } else if (minus > 0) {
                        // System.out.println("Есть знак -, его индекс: " + minus); // вспомогательный код (спрятать)
                        rezultat = a-b;
                        System.out.println("Результат: " + rezultat);
                    } else if (proiz > 0) {
                        // System.out.println("Есть знак *, его индекс: " + proiz); // вспомогательный код (спрятать)
                        rezultat = a*b;
                        System.out.println("Результат: " + rezultat);
                    } else if (delen > 0) {
                        // System.out.println("Есть знак /, его индекс: " + delen); // вспомогательный код (спрятать)
                        rezultat = a/b;
                        System.out.println("Результат: " + rezultat);
                    }
                }

            } else if (word == 5) {
                // System.out.println("Условие 5 символов в строке"); // вспомогательный код (спрятать)

                int rezultat;
                if (a>=11 || b>=11) { // ограничение на число до 10 включительно
                    throw new IOException(); // Калькулятор может работать только с целыми числами от 1 до 10 включительно
                    // System.out.println("Калькулятор может работать только с целыми числами от 1 до 10 включительно");
                } else {
                    if (plus > 0) {
                        // System.out.println("Есть знак +, его индекс: " + plus); // вспомогательный код (спрятать)
                        rezultat = a+b;
                        System.out.println("Результат: " + rezultat);
                    } else if (minus > 0) {
                        // System.out.println("Есть знак -, его индекс: " + minus); // вспомогательный код (спрятать)
                        rezultat = a-b;
                        System.out.println("Результат: " + rezultat);
                    } else if (proiz > 0) {
                        // System.out.println("Есть знак *, его индекс: " + proiz); // вспомогательный код (спрятать)
                        rezultat = a*b;
                        System.out.println("Результат: " + rezultat);
                    } else if (delen > 0) {
                        // System.out.println("Есть знак /, его индекс: " + delen); // вспомогательный код (спрятать)
                        rezultat = a/b;
                        System.out.println("Результат: " + rezultat);
                    }
                }

            } else {
                throw new IOException(); // Выражение не удовлетворяет условиям задания. Калькулятор может работать только с целыми числами от 1 до 10 включительно
                // System.out.println("Выражение не удовлетворяет условиям задания. Калькулятор может работать только с целыми числами от 1 до 10 включительно");
            }

        } else {
            throw new IOException(); // Строка не является математической операцией
            // System.out.println("Строка не является математической операцией");
        }

    }
}

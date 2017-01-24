package edu.kit.informatik;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class can be used to tests your assignment 5 implementation.<br>
 * Replace the original Terminal.java with this file.<br><br>
 *
 * 1. Do not change the package declaration!<br>
 * 2. Do not upload this file to the Praktomat!<br>
 *
 * @author  Luke 'luk3b' Bro
 * @author  Micha 'DeerMichel' Hanselmann
 * @version 1.0.0
 * @license WTFPL
 * @link    https://github.com/luk3b/prog-assignment-tests
 */
public class Terminal {
    // ############ CONFIGURATION START ############
    /**
     * Hide statistics at the end? This includes
     *   the total number of tests as well as
     *   the pass rate.
     */
    private static boolean CONF_HIDE_STATS = false;

    /**
     * Disable colors? Colors only work in Terminals
     *   with ANSI color support, the windows command
     *   prompt e.g. does _not_ support this.
     */
    private static boolean CONF_DISABLE_COLORS = false;

    // ############ CONFIGURATION END ############
    // Do not change anything below this line!

    /**
     * ANSI color codes
     */
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_RED   = "\u001B[31m";
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_BLUE  = "\u001B[34m";

    /**
     * Index counters
     */
    private static int i = -1,
                       o = 0;
    private static boolean pass;

    /**
     * Init status
     */
    private static boolean init = false;

    /**
     * Tests storage
     */
    private static Map<String, String[]> tests = new LinkedHashMap<>();
    private static Object[] cmds;
    private static Object[] outp;

    /**
     * Stats
     */
    private static int TESTS_TOTAL  = 0;
    private static int TESTS_PASSED = 0;

    /**
     * Returns true if system is Windows<br>
     * Probably not 100% correct but should be fine for this dirty test
     *
     * @return true if Windows, false otherwise
     */
    private static boolean isWindows() {
      //return System.getProperty("os.name").toLowerCase().contains("win");

      // while the windows command prompt doesn't support ansi colors,
      //   you could use MINGW or another Terminal for windows with
      //   color support
      // didn't find any reliable way to check for color support at
      //   the moment...
      return false;
    }

    /**
     * Prints a line without modification
     *
     * @param str Line to print
     */
    private static void sysPrintLine(String str) {
        System.out.println(str);
    }

    /**
     * Prints a command
     *
     * @param cmd Command to print
     */
    private static void sysPrintCommand(String cmd) {
        System.out.println((CONF_DISABLE_COLORS || isWindows()) ? "> " + cmd : COLOR_GREEN + "> " + cmd + COLOR_RESET);
    }

    /**
     * Prints an output
     *
     * @param str Output to print
     */
    private static void sysPrintOutput(String str) {
        System.out.println((CONF_DISABLE_COLORS || isWindows()) ? str : COLOR_BLUE + str + COLOR_RESET);
    }

    /**
     * Prints an error
     *
     * @param error Error to print
     */
    private static void sysPrintError(String error) {
        System.out.println((CONF_DISABLE_COLORS || isWindows()) ? "! " + error : COLOR_RED + "! " + error + COLOR_RESET);
    }

    /**
     * Inits test
     */
    private static void init() {
        // there is just one small drawback of using a
        // linked hashmap here: it's impossible to test
        // two identical commands

        // tests are copied from
        // https://github.com/DeerMichel/kit-assignment-tests

        // add-professor
        tests.put("add-professor roman;forst;ddf", new String[] {
                "Ok"
              });
        tests.put("add-professor dominik;saller;xxc", new String[] {
                "Ok"
              });
        tests.put("add-professor robert;amsel;ifd", new String[] {
                "Ok"
              });
        tests.put("add-professor maximiliane;frei;hgs", new String[] {
                "Ok"
              });
        tests.put("add-professor andreas;kappel;sww", new String[] {
                "Ok"
              });
        tests.put("add-professor angelika;huffman;itc", new String[] {
                "Ok"
              });
        tests.put("add-professor angelika;huffman;abg", new String[] {
                "Ok"
              });

         // add-professor errors
        tests.put("add-professor heinz;thorsten;abg;1.0", new String[] {
                "Error,"
              });
        tests.put("add-professor Dieter;huffman;reg", new String[] {
                "Error,"
              });
        tests.put("add-professor heinz;thorsten", new String[] {
                "Error,"
              });
        tests.put("add-professor stiehl", new String[] {
                "Error,"
              });
        tests.put("add-professor", new String[] {
                "Error,"
              });

        // add-student
        tests.put("add-student thorsten;doernbach;123455", new String[] {
                "Ok"
              });
        tests.put("add-student micha;hanselmann;197882", new String[] {
                "Ok"
              });
        tests.put("add-student max;maxtermann;817292", new String[] {
                "Ok"
              });
        tests.put("add-student der;fabi;201526", new String[] {
                "Ok"
              });
        tests.put("add-student jan;lang;127844", new String[] {
                "Ok"
              });

        // add-student errors
        tests.put("add-student fritz;doernbach;123455", new String[] {
                "Error,"
              });
        tests.put("add-student hans;doernbach;99999", new String[] {
                "Error,"
              });
        tests.put("add-student hans;doernbach;3456732", new String[] {
                "Error,"
              });
        tests.put("add-student hans;doernbach;099999", new String[] {
                "Error,"
              });
        tests.put("add-student hans;doernbach;-13255", new String[] {
                "Error,"
              });
        tests.put("add-student hans;doernbach;abc123", new String[] {
                "Error,"
              });
        tests.put("add-student hans;doernbach;345323;ab", new String[] {
                "Error,"
              });
        tests.put("add-student hans;doernbach;99999;", new String[] {
                "Error,"
              });
        tests.put("add-student hans;Horst;345323", new String[] {
                "Error,"
              });
        tests.put("add-student hans;ohnem", new String[] {
                "Error,"
              });
        tests.put("add-student christian", new String[] {
                "Error,"
              });
        tests.put("add-student", new String[] {
                "Error,"
              });

        // add-module
        tests.put("add-module algos", new String[] {
                "Ok"
              });
        tests.put("add-module betriebssys", new String[] {
                "Ok"
              });
        tests.put("add-module softwaretech", new String[] {
                "Ok"
              });

        // add-module errors
        tests.put("add-module RO", new String[] {
                "Error,"
              });
        tests.put("add-module", new String[] {
                "Error,"
              });
        tests.put("add-module ro;t", new String[] {
                "Error,"
              });

        // add-lecture
        tests.put("add-lecture proggen;3;roman;forst;ddf;9", new String[] {
                "Ok"
              });
        tests.put("add-lecture irgendwas;2;robert;amsel;ifd;5", new String[] {
                "Ok"
              });
        tests.put("add-lecture zocken;3;roman;forst;ddf;9", new String[] {
                "Ok"
              });
        tests.put("add-lecture undnochmalproggen;3;roman;forst;ddf;9", new String[] {
                "Ok"
              });
        tests.put("add-lecture einevl;3;roman;forst;ddf;9", new String[] {
                "Ok"
              });
        tests.put("add-lecture letztevlimmodul;3;maximiliane;frei;hgs;8", new String[] {
                "Ok"
              });
        tests.put("add-lecture genaumaxetcs;3;roman;forst;ddf;1", new String[] {
                "Ok"
              });

        // add-lecture errors
        tests.put("add-lecture Proggen;2;roman;forst;ddf;9", new String[] {
                "Error,"
              });
        tests.put("add-lecture zuvieletcs;3;roman;forst;ddf;1", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus;2;roman;forst;tgi;1", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus;2;roman;forst;ddf;1;2", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus;2;roman;forst;ddf", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus;2;roman;forst", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus;2;roman", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus;2", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus", new String[] {
                "Error,"
              });
        tests.put("add-lecture", new String[] {
                "Error,"
              });
        tests.put("add-lecture mirgehndieideenaus;4;roman;forst;ddf;1", new String[] {
                "Error,"
              });
        tests.put("add-lecture proggen;1;roman;forst;ddf;10", new String[] {
                "Error,"
              });
        tests.put("add-lecture dieter;1;roman;forst;ddf;-1", new String[] {
                "Error,"
              });
        tests.put("add-lecture loman;1;roman;forst;ddf;0", new String[] {
                "Error,"
              });
        tests.put("add-lecture loman;a;roman;forst;ddf;1", new String[] {
                "Error,"
              });
        tests.put("add-lecture loman;1;roman;forst;ddf;b", new String[] {
                "Error,"
              });

        // examination-marking
        tests.put("examination-marking 4;197882;1.105", new String[] {
                "Ok"
              });
        tests.put("examination-marking 5;197882;3.45", new String[] {
                "Ok"
              });
        tests.put("examination-marking 4;201526;2.00", new String[] {
                "Ok"
              });
        tests.put("examination-marking 6;127844;2.5", new String[] {
                "Ok"
              });
        tests.put("examination-marking 4;127844;5.0", new String[] {
                "Ok"
              });
        tests.put("examination-marking 6;817292;2.595", new String[] {
                "Ok"
              });

        // examination-marking errors
        tests.put("examination-marking 4;197882;1.1", new String[] {
                "Error,"
              });
        tests.put("examination-marking 8;197881;1.1", new String[] {
                "Error,"
              });
        tests.put("examination-marking 34;197882;1.1", new String[] {
                "Error,"
              });
        tests.put("examination-marking bb;197882;1.1", new String[] {
                "Error,"
              });
        tests.put("examination-marking 8;197882;1,1", new String[] {
                "Error,"
              });
        tests.put("examination-marking 8;197882;5.1", new String[] {
                "Error,"
              });
        tests.put("examination-marking 8;197882;0.9", new String[] {
                "Error,"
              });
        tests.put("examination-marking 8;197882;1;2", new String[] {
                "Error,"
              });
        tests.put("examination-marking 8;197882", new String[] {
                "Error,"
              });
        tests.put("examination-marking 8", new String[] {
                "Error,"
              });
        tests.put("examination-marking", new String[] {
                "Error,"
              });

        // list-student
        tests.put("list-student", new String[] {
                "123455 thorsten doernbach none",
                "127844 jan lang 3.75",
                "197882 micha hanselmann 1.94",
                "201526 der fabi 2.00",
                "817292 max maxtermann 2.60"
              });

        // summary-student
        tests.put("summary-student max;maxtermann;817292", new String[] {
                "6 zocken 2.60"
              });

        // summary-student errors
        tests.put("summary-student micha;hanselmann;197881", new String[] {
                "Error,"
              });
        tests.put("summary-student micha;hufmann;197882", new String[] {
                "Error,"
              });
        tests.put("summary-student dieter;hanselmann;197882;1", new String[] {
                "Error,"
              });
        tests.put("summary-student dieter;hanselmann", new String[] {
                "Error,"
              });
        tests.put("summary-student dieter", new String[] {
                "Error,"
              });
        tests.put("summary-student", new String[] {
                "Error,"
              });

        // list-module
        tests.put("list-module", new String[] {
                "1 algos 0 none",
                "2 betriebssys 5 3.45",
                "3 softwaretech 45 2.62"
              });

        // summary-module
        tests.put("summary-module 2", new String[] {
                "5 irgendwas 5 3.45"
              });

        // summary-modules errors
        tests.put("summary-module abc", new String[] {
                "Error,"
              });
        tests.put("summary-module 1;a", new String[] {
                "Error,"
              });
        tests.put("summary-module 42", new String[] {
                "Error,"
              });
        tests.put("summary-module", new String[] {
                "Error,"
              });

        // list-lecture
        tests.put("list-lecture", new String[] {
                "4 proggen 9 2.70",
                "5 irgendwas 5 3.45",
                "6 zocken 9 2.55",
                "7 undnochmalproggen 9 none",
                "8 einevl 9 none",
                "9 letztevlimmodul 8 none",
                "10 genaumaxetcs 1 none"
              });

        // summary-lecture
        tests.put("summary-lecture 5", new String[] {
                "197882 micha hanselmann 3.45"
              });

        // summary-lecture errors
        tests.put("summary-lecture 2", new String[] {
                "Error,"
              });
        tests.put("summary-lecture 4;a", new String[] {
                "Error,"
              });
        tests.put("summary-lecture", new String[] {
                "Error,"
              });

        // list-professor
        tests.put("list-professor", new String[] {
                "sww andreas kappel none",
                "abg angelika huffman none",
                "itc angelika huffman none",
                "xxc dominik saller none",
                "hgs maximiliane frei none",
                "ifd robert amsel 3.45",
                "ddf roman forst 2.62"
              });

        // summary-professor
        tests.put("summary-professor robert;amsel;ifd", new String[] {
                "5 irgendwas 3.45"
              });

        // summary-professor errors
        tests.put("summary-professor robert;amsel;ddf", new String[] {
                "Error,"
              });
        tests.put("summary-professor roBert;amsel;ifd", new String[] {
                "Error,"
              });
        tests.put("summary-professor robert;amsel;ifd;d", new String[] {
                "Error,"
              });
        tests.put("summary-professor robert;amsel", new String[] {
                "Error,"
              });
        tests.put("summary-professor robert", new String[] {
                "Error,"
              });
        tests.put("summary-professor ", new String[] {
                "Error,"
              });

        // reset
        tests.put("reset ds", new String[] {
                "Error,"
              });
        tests.put("reset", new String[] {
                "Ok"
              });

        // misc
        tests.put("a", new String[] {
                "Error,"
              });
        tests.put("a;a;B", new String[] {
                "Error,"
              });
        tests.put("List-professor", new String[] {
                "Error,"
              });

        // quit
        tests.put("Quit", new String[] {
                "Error,"
              });
        tests.put("quit ;", new String[] {
                "Error,"
              });

        cmds = tests.keySet().toArray();
        outp = tests.values().toArray();
        init = !init;

        sysPrintLine("All tests come with ABSOLUTELY NO WARRANTY. Do NOT upload this file to the Praktomat!");
        sysPrintLine("See source of file to configure statistics and color support.");
    }

    /**
     * Returns next command, logs it to Terminal and checks for
     *   missing lines.
     *
     * @return Next command, "quit" if no next command available
     */
    public static String readLine() {
        if(!init)
            init();

        // check for missing lines
        if(i >= 0) {
            String[] out = (String[]) outp[i];
            if(o < out.length) {
                for(int i = o; i <= out.length - 1; i++) {
                    sysPrintError("Missing line, expected '" + out[i] + "'");
                    pass = false;
                }
            }
        }

        if(pass)
            TESTS_PASSED++;

        o = 0;
        i++;
        TESTS_TOTAL++;
        pass = true;

        // end of test, do calculation
        if(i >= tests.size()) {
            sysPrintCommand("quit");
            TESTS_PASSED++;

            if(!CONF_HIDE_STATS) {
                sysPrintLine("-------------------------");
                sysPrintLine("Total tests finished: " + TESTS_TOTAL);
                sysPrintLine("PASSED: " + TESTS_PASSED + " (" + String.format("%.1f", ((float) TESTS_PASSED / TESTS_TOTAL) * 100.0f) + "%), FAILED: " + (TESTS_TOTAL - TESTS_PASSED));
            }

            return "quit";
        }

        String cmd = (String) cmds[i];
        sysPrintCommand(cmd);

        return cmd;
    }

    /**
     * Prints line to Terminal and checks for correctness
     *
     * @param str Line to print
     */
    public static void printLine(String str) {
        if(!init)
            return;

        String[] out = (String[]) outp[i];
        sysPrintOutput(str);

        if(o > out.length - 1) {
            sysPrintError("Output too long!");
            pass = false;
            o++;
            return;
        }

        if(out[o].startsWith("Error,")) {
            if(!str.startsWith("Error,")) {
                sysPrintError("! Expected error message");
                pass = false;
            }
        } else {
            if(!str.equals(out[o])) {
                sysPrintError("Incorrect output! (" + str + ")");
                pass = false;
            }
        }

        o++;
    }

    /**
     * Prints error to Terminal
     *
     * @param str The error to print
     */
    public static void printError(String str) {
        printLine("Error, " + str);
    }
}

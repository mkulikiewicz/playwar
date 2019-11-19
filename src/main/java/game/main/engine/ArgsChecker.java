package game.main.engine;

/**
 * Utwórz klasę testową ArgsCheckerTest
 */
class ArgsChecker {

    /**
     * Napisz 2 przypadek testowy w którym sprawdzisz że
     * - nie można sparsować stringa
     * - można sparsować stringa
     * @param args
     * @return
     */
    int trySignArgs(String[] args) {
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            return 5;
        }
    }
}

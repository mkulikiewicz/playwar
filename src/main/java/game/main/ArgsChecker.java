package game.main;

class ArgsChecker {

    int trySignArgs(String[] args) throws NumberFormatException {
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            return 5;
        }
    }
}

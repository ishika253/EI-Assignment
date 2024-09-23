import java.util.Scanner;
import utils.LoggerUtil;
import stages.StageHandler;

public class RocketLaunchSimulator {
    private FlightSimulator flightSimulator;
    private Scanner scanner;

    public RocketLaunchSimulator() {
        this.flightSimulator = new FlightSimulator();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        String input;
        boolean exit = false;

        LoggerUtil.logInfo("Welcome to the Rocket Launch Simulator!");
        while (!exit) {
            System.out.print("Enter command (start_checks, launch, fast_forward X, or exit): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("start_checks")) {
                flightSimulator.startChecks();
            } else if (input.equalsIgnoreCase("launch")) {
                flightSimulator.launch();
            } else if (input.startsWith("fast_forward")) {
                try {
                    String[] parts = input.split(" ");
                    int seconds = Integer.parseInt(parts[1]);
                    flightSimulator.fastForward(seconds);
                } catch (Exception e) {
                    LoggerUtil.logSevere("Invalid input. Use format: fast_forward X");
                }
            } else if (input.equalsIgnoreCase("exit")) {
                LoggerUtil.logInfo("Exiting simulator.");
                exit = true;
            } else {
                LoggerUtil.logSevere("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        RocketLaunchSimulator simulator = new RocketLaunchSimulator();
        simulator.start();
    }
}

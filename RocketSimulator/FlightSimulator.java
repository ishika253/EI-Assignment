import stages.StageHandler;
import utils.LoggerUtil;

public class FlightSimulator {
    private String stage;
    private int fuel;
    private int altitude;
    private int speed;
    private boolean systemsGo;
    private int currentStage;
    private final int stageSeparationAltitude;
    private final int orbitAltitude;
    private StageHandler stageHandler;

    public FlightSimulator() {
        this.stage = "Pre-Launch";
        this.fuel = 100;
        this.altitude = 0;
        this.speed = 0;
        this.systemsGo = false;
        this.currentStage = 1;
        this.stageSeparationAltitude = 300;
        this.orbitAltitude = 400;
        this.stageHandler = new StageHandler();
    }

    public void startChecks() {
        LoggerUtil.logInfo("Performing pre-launch checks...");
        LoggerUtil.logInfo("All systems are 'Go' for launch.");
        this.systemsGo = true;
    }

    public void launch() {
        if (!systemsGo) {
            LoggerUtil.logSevere("Cannot launch. Pre-launch checks not complete.");
            return;
        }
        
        LoggerUtil.logInfo("Launching the rocket!");
        this.stage = "Flight";
        simulateFlight();
    }

    private void simulateFlight() {
        int second = 0;
        try {
            while (this.altitude < this.orbitAltitude && this.fuel > 0) {
                Thread.sleep(1000);
                updateFlight(second);

                if (this.altitude >= this.stageSeparationAltitude && this.currentStage == 1) {
                    stageHandler.separateStage(currentStage);
                    currentStage++;
                    LoggerUtil.logInfo("Stage 1 complete. Separating stage. Entering Stage 2.");
                }

                if (this.altitude >= this.orbitAltitude) {
                    LoggerUtil.logInfo("Orbit achieved! Mission Successful.");
                    return;
                }

                if (this.fuel <= 0) {
                    LoggerUtil.logSevere("Mission Failed due to insufficient fuel.");
                    return;
                }

                second++;
            }
        } catch (InterruptedException e) {
            LoggerUtil.logSevere("Flight simulation interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void updateFlight(int second) {
        this.fuel -= 1;
        this.altitude += 10;
        this.speed += 1000;
        LoggerUtil.logInfo(String.format("Stage: %d, Fuel: %d%%, Altitude: %d km, Speed: %d km/h", 
            this.currentStage, this.fuel, this.altitude, this.speed));
    }

    public void fastForward(int seconds) {
        LoggerUtil.logInfo(String.format("Fast forwarding by %d seconds.", seconds));
        for (int i = 0; i < seconds; i++) {
            if (this.altitude >= this.orbitAltitude || this.fuel <= 0) {
                break;
            }
            updateFlight(i);
        }
    }
}

package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        driveDirect(250, 250);

        //driveDirect(-500, 500);


        //what would you like me to do, Clever Human?




    }
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {

      //  readSensors(SENSORS_WALL);

       // int close= getWallSignal();
       // dashboard.log("Hello! I'm a Clever Robot "+close);
        readSensors(SENSORS_BUMPS_AND_WHEEL_DROPS);
        if(isBumpLeft()) {
dashboard.log("Hit Left");

            driveDirect(-500,500);
        }
        }
}
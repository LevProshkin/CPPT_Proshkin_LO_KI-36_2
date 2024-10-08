package KI_36.Proshkin.Lab3;

import java.io.IOException;

/**
 * Interface for fire modes.
 */
public interface FireModes {
    void automaticShoot() throws IOException;
    void burstShoot() throws IOException;
    void fullLoadShoot() throws IOException;
}

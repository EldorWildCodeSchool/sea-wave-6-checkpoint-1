package dev.wilders;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Admin extends ITPerson {

    protected LocalDate lastCertified;

    public Admin(String name, LocalDate lastCertified) {
        super(name);
        this.lastCertified = lastCertified;
    }

    public void setLastCertified(LocalDate lastCertified) {
        this.lastCertified = lastCertified;
    }

    private boolean shouldRecert(){
        long daysSinceLastCert = ChronoUnit.DAYS.between(this.lastCertified, LocalDate.now());
        return daysSinceLastCert > 365;
    }

    @Override
    public boolean hasReadAccess() {
        return !shouldRecert();
    }

    @Override
    public boolean hasWriteAccess() {
        return !shouldRecert();
    }
}

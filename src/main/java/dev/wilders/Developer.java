package dev.wilders;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Developer extends ITPerson {

    protected LocalDate employmentDate;

    public Developer(String name, LocalDate employmentDate) {
        super(name);
        this.employmentDate = employmentDate;
    }

    private boolean isInTrialPeriod(){
        long monthSinceEmpl = ChronoUnit.MONTHS.between(this.employmentDate, LocalDate.now());
        return monthSinceEmpl < 6;
    }

    @Override
    public boolean hasReadAccess() {
        return true;
    }

    @Override
    public boolean hasWriteAccess() {
        return !isInTrialPeriod();
    }
}

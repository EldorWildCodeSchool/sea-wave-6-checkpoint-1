package dev.wilders;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckITPersonAccessTest {

    @Test
    public void checkAccessForITAdmins() {
        // Arrange
        LocalDate lastCertificationOneMonthAgo = LocalDate.now().minusMonths(1);
        ITPerson adminValid = new Admin("superadmin_valid", lastCertificationOneMonthAgo);

        // Act + Assert
        assertTrue(adminValid.hasReadAccess(), "Admin should have read access");
        assertTrue(adminValid.hasWriteAccess(), "Admin should have write access");

        // Arrange
        LocalDate lastCertificationOneYearAndOneDayAgo = LocalDate.now().minusYears(1).minusDays(1);
        ITPerson adminInvalid = new Admin("superadmin_invalid", lastCertificationOneYearAndOneDayAgo);

        // Act + Assert
        assertTrue(adminInvalid.hasReadAccess(), "Admin should always have read access");
        assertFalse(adminInvalid.hasWriteAccess(), "Invalid Admin should have no write access");
    }

    @Test
    public void checkAccessForITDeveloper() {
        // Arrange
        LocalDate developerHiredTwoYearsAgo = LocalDate.now().minusYears(2);
        ITPerson developerValid = new Developer("developer_valid", developerHiredTwoYearsAgo);

        // Act + Assert
        assertTrue(developerValid.hasReadAccess(), "Developer should always have read access");
        assertTrue(developerValid.hasWriteAccess(), "Developer should not have write access as she was employed only last month");

        // Arrange
        LocalDate developerHiredLessThanHalfYearAgo = LocalDate.now().minusMonths(6).plusDays(1);
        ITPerson developerInValid = new Developer("developer_invalid", developerHiredLessThanHalfYearAgo);

        // Act + Assert
        assertTrue(developerInValid.hasReadAccess(), "Developer should always have read access");
        assertFalse(developerInValid.hasWriteAccess(), "Developer should have write access as she is employed more than 6 months");

        // Arrange
        LocalDate developerHiredMoreThanHalfYearAgo = LocalDate.now().minusMonths(6).minusDays(1);
        ITPerson developerValidAgain = new Developer("developer_valid", developerHiredMoreThanHalfYearAgo);

        // Act + Assert
        assertTrue(developerValidAgain.hasReadAccess(), "Developer should always have read access");
        assertTrue(developerValidAgain.hasWriteAccess(), "Developer should have write access as she is employed more than 6 months");
    }

    @Test
    public void checkAccessForITSupport() {
        // Arrange
        ITPerson supportLevel0 = new Support("support_level_0", 0);

        // Act + Assert
        assertFalse(supportLevel0.hasReadAccess(), "Support level 0 should not have read access");
        assertFalse(supportLevel0.hasWriteAccess(), "Support level 0 should not have write access");

        // Arrange
        ITPerson supportLevel1 = new Support("support_level_1", 1);

        // Act + Assert
        assertTrue(supportLevel1.hasReadAccess(), "Support level 1 should have read access");
        assertFalse(supportLevel1.hasWriteAccess(), "Support level 1 should not have write access");

        // Arrange
        ITPerson supportLevel2 = new Support("support_level_2", 2);

        // Act + Assert
        assertTrue(supportLevel2.hasReadAccess(), "Support level 2 should have read access");
        assertTrue(supportLevel2.hasWriteAccess(), "Support level 2 should have write access");
    }
}
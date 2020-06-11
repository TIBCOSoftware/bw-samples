--
-- Delete data for table ActivityLoggingStats
--
DELETE FROM activityloggingstats WHERE timestmp BETWEEN 1578561456693 AND 1578562521690;

--
-- Delete data for table ProcessInstanceLoggingStats
--
DELETE FROM processinstanceloggingstats WHERE timestmp BETWEEN 1578561456693 AND 1578562521690;

--
-- Delete data for table TransitionLoggingStats
--
DELETE FROM transitionloggingstats WHERE timestmp BETWEEN 1578561456693 AND 1578562521690;


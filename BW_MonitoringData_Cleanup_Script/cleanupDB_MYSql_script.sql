--
-- Cleanup the data between the given timestamp.
-- Provide low_timestamp and high_timestamp value.
-- (e.g. @low_timestamp= 1578563669021;).
--

SET @low_timestamp= 1578563669021;
SET @high_timestamp = 1578563679090;
SET SQL_SAFE_UPDATES = 0;

--
-- Delete data for table ActivityLoggingStats
--
DELETE FROM ActivityLoggingStats 
WHERE timestmp 
BETWEEN @low_timestamp AND @high_timestamp;

--
-- Delete data for table ProcessInstanceLoggingStats
--
DELETE FROM ProcessInstanceLoggingStats 
WHERE timestmp 
BETWEEN @low_timestamp AND @high_timestamp;

--
-- Delete data for table TransitionLoggingStats
--
DELETE FROM TransitionLoggingStats 
WHERE timestmp 
BETWEEN @low_timestamp AND @high_timestamp;

SET SQL_SAFE_UPDATES = 1;

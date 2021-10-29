--
-- Cleanup the data between the given timestamp.
-- Provide low_timestamp and high_timestamp value at line number 15,22,and 29.
-- (e.g.: DELETE FROM ActivityLoggingStats 
--        WHERE timestmp 
--        BETWEEN 1278563669021 AND 1578563669021;
--  ).
--

--
-- Delete data for table ActivityLoggingStats
--
DELETE FROM ActivityLoggingStats 
WHERE timestmp 
BETWEEN 0 AND 0;

--
-- Delete data for table ProcessInstanceLoggingStats
--
DELETE FROM ProcessInstanceLoggingStats 
WHERE timestmp 
BETWEEN 0 AND 0;

--
-- Delete data for table TransitionLoggingStats
--
DELETE FROM TransitionLoggingStats 
WHERE timestmp 
BETWEEN 0 and 0;

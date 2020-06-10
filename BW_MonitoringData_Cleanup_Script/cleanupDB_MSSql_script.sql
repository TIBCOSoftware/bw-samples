--
-- Cleanup the data between the given timestamp.
-- Provide low_timestamp and high_timestamp value.
-- (e.g. SET @high_timestamp = 1578640730179).
--
DECLARE @low_timestamp BIGINT
SET @low_timestamp = 0

DECLARE @high_timestamp BIGINT
SET @high_timestamp = 1578641000000

--
-- Delete data for table activityloggingstats
--
DELETE FROM activityloggingstats
WHERE timestmp BETWEEN @low_timestamp AND @high_timestamp;

--
-- Delete data for table processinstanceloggingstats
--
DELETE FROM processinstanceloggingstats
WHERE timestmp BETWEEN @low_timestamp AND @high_timestamp;

--
-- Delete data for table transitionloggingstats
--
DELETE FROM transitionloggingstats
WHERE timestmp BETWEEN @low_timestamp AND @high_timestamp;


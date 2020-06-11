--
-- Cleanup the data between the given timestamp.
-- Provide low_timestamp and high_timestamp value.
--
DEFINE low_timestamp=1586331221384;
DEFINE high_timestamp=1586331221770;

--
-- Delete data for table activityloggingstats
--
DELETE FROM "ACTIVITYLOGGINGSTATS"
WHERE "TIMESTMP" BETWEEN '&&low_timestamp' AND '&&high_timestamp';

COMMIT;
--
-- Delete data for table processinstanceloggingstats
--
DELETE FROM "PROCESSINSTANCELOGGINGSTATS"
WHERE "TIMESTMP" BETWEEN '&low_timestamp' AND '&high_timestamp';

COMMIT;
--
-- Delete data for table transitionloggingstats
--
DELETE FROM "TRANSITIONLOGGINGSTATS"
WHERE "TIMESTMP" BETWEEN '&low_timestamp' AND '&high_timestamp';

COMMIT;

UNDEFINE low_timestamp;
UNDEFINE high_timestamp;



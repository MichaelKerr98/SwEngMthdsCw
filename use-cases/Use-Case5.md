# USE CASE: 5 Produce a report that shows the name, country and population.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an Organisation I want to produce a report that shows the name, country and population of either a city or capital city.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We know the name, country, district and population in either a city or capital city. Database contains capital/city data.

### Success End Condition

A report is available to the Organisation to provide to the Organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation.

### Trigger

A request for name, country and population of capital/city data is sent to organisation.

## MAIN SUCCESS SCENARIO

1. Organisation requests name, country and population of either a city or capital city.
2. Organisation captures name, country and population of either a city or capital city to get city information for.
3. Organisation extracts name, country and population.
4. Organisation provides report to Organisation.

## EXTENSIONS

3. **City or capital city not in database**:
    i. Organisation informs Organisation either the city or capital city not in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release v0.2
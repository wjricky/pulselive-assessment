# Introduction

The purpose of this exercise is to demonstrate your ability to use 
Java to build a dynamic football league table generator.

#Task

Consider a league table for football. Each team plays a number of matches and the results
of each match build the table. Given the code attached as a starting point build
the LeagueTable class that can take a list of completed matches and produce a sorted 
list of LeagueTableEntry objects.

The sorting rules for entries in the league table should be
* Sort by total points (descending)
* Then by goal difference (descending)
* Then by goals scored (descending)
* Then by team name (in alphabetical order)
A win is worth three points to the winning team. A draw is worth one point to each team.

Your code will be run through a series of JUnit tests to validate the implementation so it is important 
that method signatures are not changed. You will also be assessed on code quality and clarity.

In undertaking this task, please consider the following:
* You should be submitting production quality code
* Future reuse and extension of code
* Any documentation / notes on build

#Summary
Below three classes are updated/created:
* **LeagueTable** class is updated for all league table logic.
* **LeagueTableTest** class created for JUnit test cases.
* **Main** class created to generate three tables of historic English Premier League seasons.

#Enviroment/Prerequisite
* Eclipse, Maven, Java 8, JUnit 5

#How to build 
```
mvn clean install
```

#How to run main class
```
mvn exec:java -Dexec.mainClass=com.pulselive.demo.Main -Dexec.classpathScope=test
```

Below is a copy of the output generated

```
Premier League 2019-2020
#    Team                         Pl     W     D     L     F     A    GD   Pts
1    Liverpool                    38    32     3     3    85    33   +52    99
2    Man City                     38    26     3     9   102    35   +67    81
3    Man United                   38    18    12     8    66    36   +30    66
4    Chelsea                      38    20     6    12    69    54   +15    66
5    Leicester                    38    18     8    12    67    41   +26    62
6    Tottenham                    38    16    11    11    61    47   +14    59
7    Wolves                       38    15    14     9    51    40   +11    59
8    Arsenal                      38    14    14    10    56    48    +8    56
9    Sheffield United             38    14    12    12    39    39    +0    54
10   Burnley                      38    15     9    14    43    50    -7    54
11   Southampton                  38    15     7    16    51    60    -9    52
12   Everton                      38    13    10    15    44    56   -12    49
13   Newcastle                    38    11    11    16    38    58   -20    44
14   Crystal Palace               38    11    10    17    31    50   -19    43
15   Brighton                     38     9    14    15    39    54   -15    41
16   West Ham                     38    10     9    19    49    62   -13    39
17   Aston Villa                  38     9     8    21    41    67   -26    35
18   Bournemouth                  38     9     7    22    40    65   -25    34
19   Watford                      38     8    10    20    36    64   -28    34
20   Norwich                      38     5     6    27    26    75   -49    21

Premier League 2018-2019
#    Team                         Pl     W     D     L     F     A    GD   Pts
1    Man City                     38    32     2     4    95    23   +72    98
2    Liverpool                    38    30     7     1    89    22   +67    97
3    Chelsea                      38    21     9     8    63    39   +24    72
4    Tottenham                    38    23     2    13    67    39   +28    71
5    Arsenal                      38    21     7    10    73    51   +22    70
6    Man United                   38    19     9    10    65    54   +11    66
7    Wolves                       38    16     9    13    47    46    +1    57
8    Everton                      38    15     9    14    54    46    +8    54
9    Leicester                    38    15     7    16    51    48    +3    52
10   West Ham                     38    15     7    16    52    55    -3    52
11   Watford                      38    14     8    16    52    59    -7    50
12   Crystal Palace               38    14     7    17    51    53    -2    49
13   Newcastle                    38    12     9    17    42    48    -6    45
14   Bournemouth                  38    13     6    19    56    70   -14    45
15   Burnley                      38    11     7    20    45    68   -23    40
16   Southampton                  38     9    12    17    45    65   -20    39
17   Brighton                     38     9     9    20    35    60   -25    36
18   Cardiff                      38    10     4    24    34    69   -35    34
19   Fulham                       38     7     5    26    34    81   -47    26
20   Huddersfield                 38     3     7    28    22    76   -54    16

Premier League 2017-2018
#    Team                         Pl     W     D     L     F     A    GD   Pts
1    Man City                     38    32     4     2   106    27   +79   100
2    Man United                   38    25     6     7    68    28   +40    81
3    Tottenham                    38    23     8     7    74    36   +38    77
4    Liverpool                    38    21    12     5    84    38   +46    75
5    Chelsea                      38    21     7    10    62    38   +24    70
6    Arsenal                      38    19     6    13    74    51   +23    63
7    Burnley                      38    14    12    12    36    39    -3    54
8    Everton                      38    13    10    15    44    58   -14    49
9    Leicester                    38    12    11    15    56    60    -4    47
10   Newcastle                    38    12     8    18    39    47    -8    44
11   Crystal Palace               38    11    11    16    45    55   -10    44
12   Bournemouth                  38    11    11    16    45    61   -16    44
13   West Ham                     38    10    12    16    48    68   -20    42
14   Watford                      38    11     8    19    44    64   -20    41
15   Brighton                     38     9    13    16    34    54   -20    40
16   Huddersfield                 38     9    10    19    28    58   -30    37
17   Southampton                  38     7    15    16    37    56   -19    36
18   Swansea                      38     8     9    21    28    56   -28    33
19   Stoke                        38     7    12    19    35    68   -33    33
20   West Brom                    38     6    13    19    31    56   -25    31
```
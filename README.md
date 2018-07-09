# ServiceModule
Electronic Devices Service

Description:
This application represents electronic devices repair module.

Functionalities:<br>
Spring Security with 3 roles - Serviceman, Admin and Typical Employee(ROLE_USER)<br>
-Employee can:<br>
see all devices,<br>
see broken devices,<br>
set devices as broken,<br>
comment devices,<br>
add new devices.<br>

-Serviceman can:
see all devices,
see broken devices,
set devices as broken,
comment devices,
change devices status to repaired.

-Admin can:
see all devices,
see broken devices,
set devices as broken,
comment devices,
add new devices.
see serviceman assigned to repair.

<hr>

Application contains scheaduled actions which:
-break random devices,
-randomly assign serviceman to broken devices

<hr>

TO DO/Errors to eliminate:
-create addDevice form with dynamical fields


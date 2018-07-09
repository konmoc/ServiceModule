# ServiceModule
Electronic Devices Service

Description:
This application represents electronic devices repair module.

Functionalities:
Spring Security with 3 roles - Serviceman, Admin and Typical Employee(ROLE_USER)
-Employee can:
see all devices,
see broken devices,
set devices as broken,
comment devices,
add new devices.

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


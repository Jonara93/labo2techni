select per_prenom,per_nom,ro_nom,fs_nom
from personnes
join filmsseries_personnes on personnes.per_id = filmsseries_personnes.per_id
join roles on roles.ro_id = filmsseries_personnes.ro_id
join filmsseries on filmsseries_personnes.fs_id = filmsseries.fs_id
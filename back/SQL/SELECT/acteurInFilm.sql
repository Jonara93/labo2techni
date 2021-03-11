select per_nom, per_prenom, per_genre,per_ddn,per_url, ro_nom
from filmsseries
join filmsseries_personnes on filmsseries.fs_id = filmsseries_personnes.fs_id
join personnes on filmsseries_personnes.per_id = personnes.per_id
join roles on filmsseries_personnes.ro_id = roles.ro_id
where filmsseries.fs_id = 2 ;
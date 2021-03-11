select fs_nom, fs_synopsis,ty_type,fs_date_sortie,ge_genre,fs_saison,fs_episode, per_nom,per_prenom,ro_nom
from filmsseries
join public.types on public.types.ty_id = filmsseries.ty_id
join genres on genres.ge_id = filmsseries.fs_id
join filmsseries_personnes on filmsseries_personnes.fs_id = filmsseries.fs_id
join personnes on filmsseries_personnes.per_id = personnes.per_id
join roles on roles.ro_id = filmsseries_personnes.ro_id
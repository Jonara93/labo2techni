select filmsseries.fs_id,fs_nom, fs_synopsis,public.types.ty_id,ty_type,fs_date_sortie,genres.ge_id,ge_genre,fs_saison,fs_episode, fs_img,per_nom, per_prenom, per_genre,per_ddn,per_url, ro_nom
from filmsseries
join filmsseries_personnes on filmsseries.fs_id = filmsseries_personnes.fs_id
join personnes on filmsseries_personnes.per_id = personnes.per_id
join roles on filmsseries_personnes.ro_id = roles.ro_id
join public.types on  filmsseries.ty_id = public.types.ty_id
join genres on filmsseries.ge_id = genres.ge_id
where filmsseries.fs_id = 2
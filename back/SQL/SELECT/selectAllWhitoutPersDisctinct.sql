select filmsseries.fs_id ,fs_nom, fs_synopsis,ty_type,fs_date_sortie,ge_genre,fs_saison,fs_episode
from filmsseries
join public.types on public.types.ty_id = filmsseries.ty_id
join genres on genres.ge_id = filmsseries.ge_id
order by filmsseries.fs_nom, fs_date_sortie DESC
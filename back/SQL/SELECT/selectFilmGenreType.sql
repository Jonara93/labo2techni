select fs_nom,ty_type, ge_genre
from filmsseries
join genres on filmsseries.ge_id = genres.ge_id
join public.types on filmsseries.ty_id = public.types.ty_id 
select fs_nom, vs_nom
from filmsseries
join filmsseries_versions on filmsseries.fs_id = filmsseries_versions.fs_id
join versions on filmsseries_versions.vs_id = versions.vs_id
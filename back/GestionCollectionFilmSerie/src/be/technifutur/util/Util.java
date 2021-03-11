package be.technifutur.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.technifutur.dto.FilmSerie;

public class Util {
	public static void formatResponse(HttpServletResponse resp, Object obj) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
				.registerTypeAdapter(LocalDate.class, new LocalDateSerializer()).create();
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Request-Headers", "*");
		resp.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, OPTIONS, PUT, PATCH");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With,X-HTTP-Method-Override, Content-Type, Accept, Authorization");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		out.print(gson.toJson(obj));
		out.flush();
	}

	public static Map<String, String> constructMap(FilmSerie fs) {
		Map<String, String> mapOfFs = new HashMap<String, String>();
		if (fs.getFs_nom() != null) {
			mapOfFs.put("fs_nom", fs.getFs_nom());
		}
		if (fs.getFs_synopsis() != null) {
			mapOfFs.put("fs_synopsis", fs.getFs_synopsis());
		}
		if (fs.getFs_img() != null) {
			mapOfFs.put("fs_img", fs.getFs_img());
		}
		if (fs.getFs_saison() != null) {
			mapOfFs.put("fs_saison", fs.getFs_saison().toString());
		}
		if (fs.getFs_episode() != null) {
			mapOfFs.put("fs_episode", fs.getFs_episode().toString());
		}
		if (fs.getFs_date_sortie() != null) {
			mapOfFs.put("fs_date_sortie", fs.getFs_date_sortie().toString());
		}
		return mapOfFs;
	}
}

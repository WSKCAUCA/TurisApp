package com.caucaragp.worldskills.turisapp.maps;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DirectionsParser {

    public List<List<HashMap<String, String>>> parse(JSONObject jObject) {


        List<List<HashMap<String, String>>> routes = new ArrayList<>();

        JSONArray jRoutes = null;
        JSONArray jLegs = null;
        JSONArray jSteps = null;

        try {


            jRoutes = jObject.getJSONArray("routes");

            for (int i = 0; i < jRoutes.length(); i++) {

                jLegs = ((JSONObject) jRoutes.get(i)).getJSONArray("legs");
                List path = new ArrayList<HashMap<String, String>>();

                for (int j = 0; j < jLegs.length(); j++) {

                    jSteps = ((JSONObject) jLegs.get(j)).getJSONArray("steps");

                    for (int k = 0; k < jSteps.length(); k++) {

                        String polyline = "";
                        polyline = (String) ((JSONObject) ((JSONObject) jSteps.get(k)).get("polyline")).get("points");
                       // List list = decodePolyline(polyline);

                        for (int l = 0; l < jSteps.length(); l++) {
                            HashMap<String, String> hm = new HashMap<>();
                           // hm.put("lat", Double.toString(((LatLng) list.get(l)).latitude));
                            //hm.put("lon", Double.toString(((LatLng) list.get(l)).longitude));
                            path.add(hm);

                        }
                    }

                    routes.add(path);
                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return routes;

    }

    //private List decodePolyline(String encode) {

      //  int index = 0, len = encode.length();

        //int lat = 0, lng = 0;

        //while (index < len) ;


    //}
}

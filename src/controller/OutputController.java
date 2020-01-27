package src.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import src.model.Permissions;

public class OutputController {

        public static List<String> formatResult(HashMap<String, List<Permissions>> searchResult) {
                List<String> result = new ArrayList<>();

                if(searchResult.isEmpty()){
                  String line = "O email informado não retornou nenhum dado";
                  result.add(line);
                  return result;
                }
                
                Set<String> keys = searchResult.keySet();
                keys.forEach(key -> formatLine(key, searchResult.get(key), result));

                return result;
        }

        private static void formatLine(String key, List<Permissions> list, List<String> result) {
                String line = new String();

                line = line.concat(key);
                line = line.concat(";[(");

                for (int i = 0; i < list.size(); i++) {
                        line = line.concat(list.get(i).getFunction());
                        line = line.concat(",");
                        line = line.concat(list.get(i).getLevel());
                        if (i != (list.size() - 1)) {
                                line = line.concat("),(");
                        }
                }
                line = line.concat(")]");

                result.add(line);
        }

}

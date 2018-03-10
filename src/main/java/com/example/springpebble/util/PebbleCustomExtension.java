package com.example.springpebble.util;

import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yookeun on 2018. 3. 9..
 */
public class PebbleCustomExtension extends AbstractExtension {
    @Override
    public Map<String, Function> getFunctions() {
        Map<String, Function> functions = new HashMap<String, Function>();
        functions.put("scoreEval", new ScoreEval());
        return functions;
    }

    /**
     * 점수계산 pebble 클래스(Pebble에서는 함수)를 만든다
     */
    class ScoreEval implements Function {
        @Override
        public List<String> getArgumentNames() {
            List<String> names = new ArrayList<>();
            names.add("score");
            return names;
        }

        @Override
        public Object execute(Map<String, Object> args) {
            if (args.get("score") == null || args.get("score").equals("")) {
                return null;
            }
            int score = Integer.parseInt(args.get("score").toString());
            String result = "";
            if (score >= 90) {
                result = "A";
            } else if (score >= 80) {
                result = "B";
            } else if (score >= 70) {
                result = "C";
            } else {
                result = "D";
            }
            return result;
        }
    }
}

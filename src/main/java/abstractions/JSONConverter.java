package abstractions;

import datasource.conversions.JSONConversionResult;
import java.util.List;
import java.util.Map;

public interface JSONConverter {
    JSONConversionResult<String> mapToString(Map<String, ?> jsonMap);
    JSONConversionResult<Map<String, Object>> stringToMap(String jsonPayload);
    JSONConversionResult<Object> stringToObject(String jsonPayload);
    JSONConversionResult<List<?>> stringToList(String jsonPayload);
}

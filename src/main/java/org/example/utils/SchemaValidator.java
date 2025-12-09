package org.example.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.io.InputStream;
import java.util.Set;

public class SchemaValidator {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void validate(String response, String schemaFile) throws Exception {
        InputStream schemaStream = SchemaValidator.class.getClassLoader().getResourceAsStream(schemaFile);
        if (schemaStream == null) {
            throw new RuntimeException("Schema file not found: " + schemaFile);
        }

        JsonNode jsonNode = mapper.readTree(response);
        JsonSchema schema = JsonSchemaFactory.getInstance().getSchema(schemaStream);

        Set<ValidationMessage> errors = schema.validate(jsonNode);

        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            errors.forEach(e -> sb.append(e.getMessage()).append("\n"));
            throw new AssertionError("JSON schema validation failed:\n" + sb.toString());
        }
    }
}

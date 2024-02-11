package az.rock.lib.coordinator;

import java.util.List;

public record ProcessProperty(String processName, String currentStep, List<String> steps) {

}

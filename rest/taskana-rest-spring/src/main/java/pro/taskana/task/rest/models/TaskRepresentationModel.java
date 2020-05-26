package pro.taskana.task.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pro.taskana.task.api.models.Task;
import pro.taskana.task.rest.assembler.AttachmentRepresentationModelAssembler;

/**
 * EntityModel class for {@link Task}.
 */
@JsonIgnoreProperties("attachmentSummaries")
public class TaskRepresentationModel extends TaskSummaryRepresentationModel {


  protected AttachmentRepresentationModelAssembler attachmentAssembler;
  // All objects have to be serializable
  private List<CustomAttribute> customAttributes = Collections.emptyList();
  private List<CustomAttribute> callbackInfo = Collections.emptyList();
  private List<AttachmentRepresentationModel> attachments = new ArrayList<>();

  public List<CustomAttribute> getCustomAttributes() {
    return customAttributes;
  }

  public void setCustomAttributes(List<CustomAttribute> customAttributes) {
    this.customAttributes = customAttributes;
  }

  public List<CustomAttribute> getCallbackInfo() {
    return callbackInfo;
  }

  public void setCallbackInfo(List<CustomAttribute> callbackInfo) {
    this.callbackInfo = callbackInfo;
  }

  public List<AttachmentRepresentationModel> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<AttachmentRepresentationModel> attachments) {
    this.attachments = attachments;
  }

  /**
   * A CustomAttribute is a user customized attribute which is saved as a Map and can be retreived
   * from either {@link Task#getCustomAttributes()} or {@link Task#getCallbackInfo()}.
   */
  public static class CustomAttribute {

    private final String key;
    private final String value;

    @SuppressWarnings("unused")
    public CustomAttribute() {
      this(null, null);
      // necessary for jackson.
    }

    public CustomAttribute(String key, String value) {
      this.key = key;
      this.value = value;
    }

    public String getKey() {
      return key;
    }

    public String getValue() {
      return value;
    }

  }
}
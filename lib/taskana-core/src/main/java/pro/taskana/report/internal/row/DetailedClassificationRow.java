package pro.taskana.report.internal.row;

import pro.taskana.report.api.ClassificationReport;
import pro.taskana.report.internal.item.DetailedMonitorQueryItem;
import pro.taskana.report.internal.structure.Row;

/**
 * Represents a single Row inside {@link ClassificationReport.DetailedClassificationReport}. The
 * collapsing criteria is the attachement key of each {@link DetailedMonitorQueryItem}.
 */
public class DetailedClassificationRow extends FoldableRow<DetailedMonitorQueryItem> {

  public DetailedClassificationRow(int columnSize) {
    super(columnSize, (item) -> item.getAttachmentKey() != null ? item.getAttachmentKey() : "N/A");
  }

  @Override
  public SingleRow<DetailedMonitorQueryItem> getFoldableRow(String key) {
    return (SingleRow<DetailedMonitorQueryItem>) super.getFoldableRow(key);
  }

  @Override
  Row<DetailedMonitorQueryItem> buildRow(int columnSize) {
    return new SingleRow<>(columnSize);
  }
}
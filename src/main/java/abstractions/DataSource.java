package abstractions;

import datasource.DataSourceOperationResult;

public interface DataSource {
    DataSourceOperationResult open(String location);
    DataSourceOperationResult close();
    DataSourceOperationResult save();
    DataSourceOperationResult saveAs(String location);
}

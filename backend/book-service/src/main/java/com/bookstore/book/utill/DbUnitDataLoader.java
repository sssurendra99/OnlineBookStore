package com.bookstore.book.utill;

import lombok.RequiredArgsConstructor;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class DbUnitDataLoader {

    private final DataSource dataSource;

    public void executeDataset(String path) throws DatabaseUnitException, SQLException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(path);
        if (is == null) throw new RuntimeException(path + " not found");

        IDatabaseConnection conn = new DatabaseConnection(dataSource.getConnection());
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(is);
        DatabaseOperation.CLEAN_INSERT.execute(conn, dataSet);
    }

}


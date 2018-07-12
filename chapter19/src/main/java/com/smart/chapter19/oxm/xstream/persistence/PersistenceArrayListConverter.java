package com.smart.chapter19.oxm.xstream.persistence;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * PersistenceArrayListConverter
 *
 * @author ascend
 * @date 2018/7/12 9:27.
 */
public class PersistenceArrayListConverter implements Converter {
    private XStream xStream;

    public PersistenceArrayListConverter(XStream xStream) {
        this.xStream = xStream;
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        File dir = new File(System.getProperty("user.home"), "documents");
        XmlArrayList list = new XmlArrayList(new FilePersistenceStrategy(dir, xStream));
        context.convertAnother(dir);
        list.addAll((Collection) source);
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        File directory = (File) context.convertAnother(reader, File.class);
        XmlArrayList persistenceList = new XmlArrayList(new FilePersistenceStrategy(directory, xStream));
        ArrayList list = new ArrayList(persistenceList);
        persistenceList.clear();
        return list;
    }

    @Override
    public boolean canConvert(Class type) {
        return type == ArrayList.class;
    }
}


    public void WriteFile(List<Product> list) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {

            Gson gson = new Gson();
            String json = gson.toJson(list);
            oos.writeObject(json);

        } catch (IOException ex) {

            ex.printStackTrace();
        }

       /* try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(filePath), list);

        } catch (IOException ex) {

            ex.printStackTrace();
        }*/
    }

    public List<Product> ReadFile(List<Product> list) {

        File file = new File(filePath);

        if (file.length() == 0) {

            return list;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {

            Gson gson = new Gson();
            String object = (String) ois.readObject();

            /*
             * TypeToken - представляет общий тип T. Java еще не предоставляет способ представления общих типов,
             * поэтому этот класс делает это. Заставляет клиентов создавать подкласс этого класса,
             * что позволяет получить информацию о типе даже во время выполнения.
             */

            return gson.fromJson(object, new TypeToken<List<Product>>() {
            }.getType());

        } catch (ClassNotFoundException | IOException e) {

            throw new RuntimeException(e);

        }

       /* try{

            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(new File(filePath), new TypeReference<List<Product>>() {
            });

        }
        catch (IOException err){

            err.printStackTrace();
        }

        return list;*/

    }


}

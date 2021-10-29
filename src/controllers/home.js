let users = [
    {
      id: 1,
      name: "alice",
    },
    {
      id: 2,
      name: "bek",
    },
    {
      id: 3,
      name: "chris",
    },
  ];
  
export function home(req, res) {
    console.log("who get in here/users");
    res.json(users);
  }
let users = [
  {
    id: 1,
    name: "alice",
    galaxy: "1",
    type: "aaa",
  },
  {
    id: 2,
    name: "bek",
    galaxy: "4",
    type: "bbb",
  },
  {
    id: 3,
    name: "chris",
    galaxy: "3",
    type: "ccc",
  },
];

export function home(req, res) {
  console.log("who get in here/users");
  res.json(users);
}

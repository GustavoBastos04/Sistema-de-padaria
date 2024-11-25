import { useEffect, useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemProduto from "../components/ListItems/ItemProduto.jsx";
import SearchInput from "../components/SearchInputs/SearchInput.jsx";
import { api } from "../services/api.js";

function Produtos() {

    const [products, setProducts] = useState([])
    const [qtd, setQtd] = useState([])

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = products.filter((item) => item.nome.toLowerCase().includes(searchItem))
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)

    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleSearch = (term) => {
        setSearchItem(term.toLowerCase())
        setCurrentPage(1)
    }

    async function loadProducts() {
        const items = []
        try {
            const products = await api.get('produto'); // Supondo retorno com a propriedade `data`
            const qtd = await api.get('produtos-restantes'); // Supondo retorno com a propriedade `data`
    
            if (Array.isArray(products.data) && Array.isArray(qtd.data)) {
                products.data.forEach(item => {
                    const found = qtd.data.find(({ nome }) => nome === item.nome);
                    if (found) {
                        const newItem = {
                            nome: item.nome,
                            valor: item.valor,
                            quantidade: found.quantidade
                        }
                    items.push(newItem)
                    }
                });
            } else {
                console.error("products.data ou qtd.data não são arrays.");
            }
        } catch (error) {
            console.error("Erro ao carregar dados:", error);
        }
        setProducts(items)
    }

    useEffect(() => {
        loadProducts()
    }, [])

    return (
        <div>
            <SearchInput string="nome" onSearch={handleSearch}/>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Valor unitário</th>
                        <th>Quantidade</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        currentItems.map((item) => {
                            return(
                                <ItemProduto
                                key={item.id} 
                                nome={item.nome} 
                                valor={item.valor}
                                quantidade={item.quantidade}
                                flag={1}
                                />
                            )
                        })
                    }
                </tbody>
            </Table>
            <div className="pagination d-flex justify-content-center align-itens-center">
                    {Array.from({length: totalPages}, (_, index) => (
                        <Button
                        key={index+1}
                        onClick={() => handlePageChange(index+1)}
                        variant={currentPage === index + 1 ? "primary" : "outline-primary"}
                        className="m-1"
                        >
                            {index+1}
                        </Button>
                    ))}
            </div>
        </div>
    )
}

export default Produtos
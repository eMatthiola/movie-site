import React, { useEffect, useRef } from 'react'
import { Col, Container, Row } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import ReviewForm from '../reviewForm/ReviewForm';
import api from '../../api/axiosConfig'; 

const Reviews = ({getMovieData, movie, reviews, setReviews}) => {

    const revText = useRef();
    let params = useParams();
    const movieId = params.movieId;

    useEffect(() =>{
        getMovieData(movieId);
    }, [])

    const addReview = async (e) =>{
        e.preventDefault();

        const rev = revText.current;

        try {
            
            const response = await api.post("api/v1/reviews", {body:rev.value,imdbId:movieId});

            const updatedReviews = [...reviews, {body:rev.value}];

            rev.value = "";

            setReviews(updatedReviews);

        } catch (err) {
            console.error(err);
        }
    }

  return (
    <Container>
        <Row>
            <Col><h3>Reviews</h3></Col>
        </Row>
        <Row className = "mt-2">
            <Col>
                <img src={movie?.poster} alt=''/>
            </Col>
            <Col>
                {

                    <>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} revText={revText} labelText="Write a Review?" />
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                    </>
                }
                {
                    reviews?.map((r, index) => {
                        return(
                            <div key={index} >
                                <Row>
                                    <Col>{r.body}</Col>
                                </Row>
                                <Row>
                                    <Col>
                                        <hr />
                                    </Col>
                                </Row>
                            </div>
                        )
                    })
                }

            </Col>
        </Row>
    </Container>

)}

export default Reviews
